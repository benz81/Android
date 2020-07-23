// 클라이언트의 헤더에 셋팅된
// Authorization 값(Token) 을 확인하여
// 인증한다.

const jwt = require("jsonwebtoken");
const connection = require("../db/mysql_connection");

const auth = async (req, res, next) => {
  console.log("인증 미들웨어");
  let token = req.header("Authorization");
  token = token.replace("Bearer ", "");
  console.log(token);

  // 토큰에 저장된 정보를 디코드 한다.
  let user_id;
  try {
    const decoded = jwt.verify(token, process.env.ACCESS_TOKEN_SECRET);
    console.log(decoded);
    user_id = decoded.user_id;
  } catch (e) {
    res.status(401).json({ error: "이상한 토큰 보내지 마시오" });
  }
  // 위의 유저 아이디로, DB에서 token 정보를 가져온다.
  let query = `select * from token where user_id = ${user_id} `;
  try {
    [rows] = await connection.query(query);
    console.log(rows);
  } catch (e) {
    res.status(401).json({ error: "인증 먼저 하십시오" });
  }

  // 반복문 돌면서, 유저 아이디와 토큰이 맞는지 체크
  for (let i = 0; i < rows.length; i++) {
    if (rows[i].user_id == user_id && rows[i].token == token) {
      next();
      return;
    }
  }

  res.status(401).json({ error: "인증이 안된 토큰입니다." });
};

module.exports = auth;
