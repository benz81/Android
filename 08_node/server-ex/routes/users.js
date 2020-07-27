const express = require("express");
const auth = require("../middleware/auth");
const {
  createUser,
  loginUser,
  changePasswd,
  getMyInfo,
  logout,
  logoutAll,
} = require("../controllers/users");

const router = express.Router();

router.route("/").post(createUser).get(auth, getMyInfo);
router.route("/login").post(loginUser);
router.route("/change").post(changePasswd);
router.route("/logout").post(auth, logout);
router.route("/logoutAll").post(auth, logoutAll);

module.exports = router;
