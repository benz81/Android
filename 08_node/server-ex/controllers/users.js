const connection = require("../db/mysql_connection");
const ErrorResponse = require("../utils/errorResponse");
const validator = require("validator");
const bcrypt = require("bcrypt");

// @desc    회원가입
// @route   POST /api/v1/users   => 나
// @route   POST /api/v1/users/register
// @route   POST /api/v1/users/signup
// @parameters  email, passwd
exports.createUser = async (req, res, next) => {
  let email = req.body.email;
  let passwd = req.body.passwd;

  // 비밀번호와 같은 것은,
  // 단방향 암호화(복호화가 불가능)를 해야 한다.
  // 그래야, 복호화가 안되어서, 안전하다.
  // 1234(원문) => djsj32k2idhj23kkdsjaj  암호화
  // djsj32k2idhj23kkdsjaj => 1234(원문)  복호화
  const hashedPasswd = await bcrypt.hash(passwd, 8);

  // 이메일이 정상적인가 체크
  if (!validator.isEmail(email)) {
    res.status(500).json({ success: false });
    return;
  }
  // 유저 인서트
  query = "insert into user (email, passwd) values ? ";
  data = [email, hashedPasswd];

  try {
    [result] = await connection.query(query, [[data]]);
    res.status(200).json({ success: true, result: result });
  } catch (e) {
    if (e.errno == 1062) {
      // 이메일 중복된것 이다.
      res
        .status(400)
        .json({ success: false, errno: 1, message: "이메일 중복" });
    } else {
      res.status(500).json({ success: false, error: e });
    }
  }
};
