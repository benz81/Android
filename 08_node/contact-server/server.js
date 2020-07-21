const express = require("express");
const dotenv = require("dotenv");
// 로그 찍어주는 로거다. 미들웨어 다. app.use에 추가시키는 것.
const morgan = require("morgan");

const contacts = require("./routes/contacts");

dotenv.config({ path: "./config/config.env" });
const app = express();
// Body parser 설정. 클라이언트에서 body로 데이터 보내는것 처리.
app.use(express.json());

// 먼저 로그 찍어주도록 미들웨어 설정.
app.use(morgan("common"));

// API 경로연결
app.use("/api/v1/contacts", contacts);

const PORT = process.env.PORT || 5300;

app.listen(PORT, console.log("API SERVER"));
