const auth = (req, res, next) => {
  console.log("인증 미들웨어");
  next();
};

module.exports = auth;
