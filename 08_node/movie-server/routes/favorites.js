const express = require("express");
const auth = require("../middleware/auth");
const { addFavorite } = require("../controllers/favorites");

const router = express.Router();

// /api/v1/favorites
router.route("/").post(auth, addFavorite);

module.exports = router;
