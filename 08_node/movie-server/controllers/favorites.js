// 데이터베이스 처리 위한 라이브러리 필요
const connection = require("../db/mysql_connection");

// @desc    좋아하는 영화 추가
// @route   POST /api/v1/favorites
// @parameters  movie_id

exports.addFavorite = async (req, res, next) => {
  let movie_id = req.body.movie_id;
  let user_id = req.user.id;

  let query = "insert into favorite_movie (movie_id, user_id) values (?,?)";
  let data = [movie_id, user_id];

  try {
    [result] = await connection.query(query, data);
    res.status(200).json({ success: true });
  } catch (e) {
    res.status(500).json();
  }
};
