const express = require("express");
const { createUser, loginUser } = require("../controllers/users");
const router = express.Router();

// /api/v1/users
router.route("/").post(createUser);
// /api/v1/users/login
router.route("/login").post(loginUser);

module.exports = router;
