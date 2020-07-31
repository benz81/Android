// 데이터베이스 처리 위한 라이브러리 필요
const connection = require("../db/mysql_connection");

// @desc        좌석 예약 하기
// @route       POST /api/v1/reservations
// @request     movie_id, seat_no_arr[], start_time, user_id(auth)
// @response    success
exports.setReservation = async (req, res, next) => {
  let movie_id = req.body.movie_id;
  let seat_no_arr = req.body.seat_no_arr;
  let start_time = req.body.start_time;
  let user_id = req.user.id;

  if (!movie_id || !seat_no_arr || !start_time || !user_id) {
    res.status(400).json();
    return;
  }
  // 첫번째 방법 : select 해서, 해당 좌석 정보가 있는지 확인 => rows.length == 1
  // 두번째 방법 : 테이블에, movie_id, start_time, seat_no 를 unique 하게 설정.
  let query =
    "insert into movie_reservation \
  (movie_id, start_time, seat_no, user_id) values ? ";
  let data = [];
  for (let i = 0; i < seat_no_arr.length; i++) {
    data.push([movie_id, start_time, seat_no_arr[i], user_id]);
  }
  console.log(data);
  try {
    [result] = await connection.query(query, [data]);
    res.status(200).json({ success: true });
  } catch (e) {
    if (e.errno == 1062) {
      res.status(400).json({ message: "이미 예약된 자석입니다." });
    } else {
      res.status(500).json({ error: e });
    }
  }
};

// @desc        상영시간의 해당영화 좌석 정보 불러오기(모든 좌석 정보)
// @route       GET /api/v1/reservations?start_time=&movie_id=
// @request     start_time, movie_id
// @response    success, items[], cnt

exports.getReservations = async (req, res, next) => {
  let start_time = req.query.start_time;
  let movie_id = req.query.movie_id;

  if (!start_time || !movie_id) {
    res.status(400).json();
    return;
  }
  let query =
    "select id, movie_id, seat_no from movie_reservation \
  where start_time = ? and movie_id = ?";
  let data = [start_time, movie_id];

  try {
    [rows] = await connection.query(query, data);
    res.status(200).json({ success: true, items: rows, cnt: rows.length });
  } catch (e) {
    res.status(500).json({ error: e });
  }
};
