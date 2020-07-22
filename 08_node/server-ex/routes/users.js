const express = require("express");
const { createUser, loginUser, changePasswd } = require("../controllers/users");

const router = express.Router();

router.route("/").post(createUser);
router.route("/login").post(loginUser);
router.route("/change").post(changePasswd);

module.exports = router;
