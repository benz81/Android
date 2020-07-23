// 클라이언트의 헤더에 셋팅된
// Authorization 값(Token) 을 확인하여
// 인증한다.

const jwt = require("jsonwebtoken");

const auth = (req, res, next) => {
  console.log("인증 미들웨어");
  let token = req.header("Authorization");
  token = token.replace("Bearer ", "");
  console.log(token);

  // 토큰에 저장된 정보를 디코드 한다.
  const decoded = jwt.verify(token, process.env.ACCESS_TOKEN_SECRET);
  console.log(decoded);
  let user_id = decoded.user_id;

  // 위의 유저 아이디로, DB에서 token 정보를 가져온다.

  next();
};

module.exports = auth;
