// 데이터베이스 연결
const connection = require("../db/mysql_connection");
// Json Web Token
const jwt = require("jsonwebtoken");
const bcrypt = require("bcrypt");
const validator = require("validator");

// @desc    회원가입
// @route   POST /api/v1/users
// @parameters  email, passwd
exports.createUser = async (req, res, next) => {
  // 클라이언트로부터 이메일,비번 받아서 변수로 만들자
  let email = req.body.email;
  let passwd = req.body.passwd;

  if (validator.isEmail(email) == false) {
    res.status(400).json({ success: false });
    return;
  }

  const hashedPasswd = await bcrypt.hash(passwd, 8);

  let query = "insert into memo_user (email, passwd) values (?, ?)";
  let data = [email, hashedPasswd];
  let user_id;
  try {
    [result] = await connection.query(query, data);
    user_id = result.insertId;
  } catch (e) {
    res.status(500).json({ success: false, error: e });
    return;
  }

  const token = jwt.sign({ user_id: user_id }, process.env.AUTH_TOKEN_SECRET);

  query = "insert into memo_token (token, user_id) values (? , ? )";
  data = [token, user_id];
  try {
    [result] = await connection.query(query, data);
  } catch (e) {
    res.status(500).json({ success: false });
    return;
  }

  res.status(200).json({ success: true, token: token });
};

// @desc  로그인
// @url POST /api/v1/users/login
// @request  email, passwd
// @response  success, token

exports.loginUser = async (req, res, next) => {
  let email = req.body.email;
  let passwd = req.body.passwd;

  let query = "select * from memo_user where email = ? ";
  let data = [email];

  console.log(email);
  let user_id;
  try {
    [rows] = await connection.query(query, data);
    if (rows.length == 0) {
      res.status(400).json({ success: false, message: "없는 아이디" });
      return;
    }

    const isMatch = await bcrypt.compare(passwd, rows[0].passwd);
    if (isMatch == false) {
      res.status(401).json({ success: false, message: "비밀번호 틀림" });
      return;
    }
    user_id = rows[0].id;
  } catch (e) {
    res.status(500).json({ success: false, error: e });
    return;
  }

  let token = jwt.sign({ user_id: user_id }, process.env.AUTH_TOKEN_SECRET);

  query = "insert into memo_token (token, user_id) values (? , ?)";
  data = [token, user_id];
  try {
    [result] = await connection.query(query, data);
    res.status(200).json({ success: true, token: token });
    return;
  } catch (e) {
    res.status(500).json({ success: false, error: e });
    return;
  }
};

// @desc  내 정보 가져오는 API
// @url   GET /apt/v1/users/me
// @request
// @response  success,  info { id, email, created_at }

exports.myInfo = (req, res, next) => {
  // 인증 토큰 검증 통과해서 이 함수로 온다.

  let userInfo = req.user;

  res.status(200).json({ success: true, info: userInfo });
};
