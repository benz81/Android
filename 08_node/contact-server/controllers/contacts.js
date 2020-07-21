const connection = require("../db/mysql_connection");

// @desc    모든 주소록 가져오기
// @route   GET /api/v1/contacts
exports.getAllContacts = async function (req, res, next) {
  let query = "select * from contact";

  try {
    [rows, fields] = await connection.query(query);
    res.status(200).json({ success: true, items: rows, f: fields });
  } catch (e) {
    res.status(500).json({ success: false, message: "DB ERROR", error: e });
  }
};

// @desc    주소록 1개 추가하기
// @route   POST /api/v1/contacts
exports.createContact = async (req, res, next) => {
  let name = req.body.name;
  let phone = req.body.phone;

  let query = "insert into contact (name, phone) values ? ";
  let data = [name, phone];

  try {
    [result] = await connection.query(query, [[data]]);
    res.status(200).json({ success: true, result: result });
  } catch (e) {
    res.status(500).json({
      success: false,
      message: "DB ERROR",
      error: e,
    });
  }
};

// @desc    주소록 1개 수정
// @route   PUT /api/v1/contacts
exports.updateContact = (req, res, next) => {
  res.status(200).json({ success: true });
};

// @desc    주소록 1개 삭제
// @route   DELETE /api/v1/contacts
exports.deleteContact = (req, res, next) => {
  res.status(200).json({ success: true });
};
