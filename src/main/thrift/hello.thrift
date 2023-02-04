namespace java api

// 定义常量
const i8 i = 1;

// 类型定义：将i32 定义成 Integer 类型
typedef i32 Integer

// 定义枚举-number
enum Number {
  ONE ,         // a
  TWO = 2,      // b
  THREE= 0xa,   // c
}               // d

// 使用枚举
const Number myNumber = Number.ONE;

// 定义结构体-userTransport
struct User {
    1: required i32 userId;                 // a
    2: required string userName;            // b
    3: optional Address address;            // c
    4: optional string language = "china";  //d
}

// 定义 地址
struct Address {

    // 国家
    1: required string coutry;

    // 省份
    2: required string province;

    // 城市
    3: required string city;

    // 县区
    4: required string region;

    // 乡镇、街道
    5:optional string street;

    // 编号
    6: optional string no;
}

// 定义 user 异常
exception TUserException {
    1:i32 code;
    2:string message;
}

// 定义 user rpc 服务
service UserService {

    void ping();

    bool addUser(1:required User user);

    User getUser(1:required i32 userId,2:optional string userName);

    // oneway 标识符表示客户端发出请求后不必等待回复，直接进行下面操作
//    oneway bool updateUser(1:required User user)  throws (1:TUserException userException);

}
