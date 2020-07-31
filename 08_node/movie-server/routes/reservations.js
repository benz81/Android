const express = require("express");
const auth = require("../middleware/auth");
const {
  setReservation,
  getReservations,
} = require("../controllers/reservations");

const router = express.Router();

// /api/v1/reservations

router.route("/").post(auth, setReservation);
router.route("/").get(auth, getReservations);

module.exports = router;
