const express = require("express");
const auth = require("../middleware/auth");
const {
  createUser,
  loginUser,
  changePasswd,
  getMyInfo,
} = require("../controllers/users");

const router = express.Router();

router.route("/").post(createUser);
router.route("/:id").get(auth, getMyInfo);
router.route("/login").post(loginUser);
router.route("/change").post(changePasswd);

module.exports = router;
