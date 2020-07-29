const express = require("express");
const dotenv = require("dotenv");

const movies = require("./routes/movies");
const users = require("./routes/users");
const favorites = require("./routes/favorites");

dotenv.config({ path: "./config/config.env" });

const app = express();

app.use(express.json());

app.use("/api/v1/movies", movies);
app.use("/api/v1/users", users);
app.use("/api/v1/favorites", favorites);

const PORT = process.env.PORT || 6000;
app.listen(PORT, console.log("서버 실행됨"));
