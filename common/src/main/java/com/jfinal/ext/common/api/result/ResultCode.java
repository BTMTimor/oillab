package com.jfinal.ext.common.api.result;

/*
    user: Timor
    date: 2019/10/17 0017

    状态码分类(参考HTTP协议)：
    分类 |    区间    | 描述
    1++  | 100 ~ 199 | 保留
    2++  | 200 ~ 299 | 请求成功，操作成功接收并处理
    3++  | 300 ~ 399 | 接口异常，重定向，接口变更
    4++  | 400 ~ 499 | 请求错误，请求包含语法错误或无法完成请求
    5++  | 500 ~ 599 | 服务器错误，服务器在请求过程中发生了错误
*/
public enum ResultCode {
    // 1.用户错误,
    USER_NOT_LOGIN(100, "用户未登录"),
    USER_LOGIN_EXPIRE(101, "用户登录过期，请重新登录"),
    USER_HAS_EXIST(103, "用户已存在"),
    USER_NOT_EXIST(104, "用户不存在"),
    USER_LOGIN_ERROR(105, "账号或密码错误"),
    USER_V_CODE_ERROR(106, "验证码错误"),
    USER_ACCOUNT_FORBIDDEN(108, "账号已被禁用"),
    USER_LOGOUT_ERROR(110, "用户登出失败"),


    // 2++：请求成功
    SUCCESS(200, "成功"),
    DATA_ADD_SUCCESS(210, "数据添加成功"),
    DATA_DELETE_SUCCESS(211, "数据删除成功"),
    DATA_UPDATE_SUCCESS(212, "数据更新成功"),
    DATA_GET_SUCCESS(213, "数据获取成功"),
    DATA_FIND_SUCCESS(214, "数据查找成功"),
    USER_LOGOUT_SUCCESS(215, "用户登出成功"),

    DATA_BATCH_PROCESS_SUCCESS(220, "数据批量操作成功"),
    DATA_BATCH_ADD_SUCCESS(221, "数据批量添加成功"),
    DATA_BATCH_DELETE_SUCCESS(222, "数据批量删除成功"),
    DATA_BATCH_UPDATE_SUCCESS(223, "数据批量更新成功"),

    SYNCHRONOUS_DATA_SUCCESS(223, "数据更新同步成功"),
    IMPORT_DATA_SUCCESS(224, "数据导入成功"),


    // 3++：接口调用错误
    API_INNER_INVOKE_ERROR(301, "内部系统接口调用异常"),
    API_OUTER_INVOKE_ERROR(302, "外部系统接口调用异常"),
    API_FORBID_VISIT(303, "该接口禁止访问"),
    API_ADDRESS_INVALID(304, "接口地址无效"),
    API_ADDRESS_CHANGE(305, "接口地址变更"),
    API_REQUEST_TIMEOUT(306, "接口请求超时"),
    API_EXCEED_LOAD(307, "接口负载过高"),
    API_NOT_EXIST(308, "接口不存在"),
    // 33+.参数错误
    PARAM_IS_INVALID(331, "参数无效"),
    PARAM_IS_BLANK(332, "参数为空"),
    PARAM_TYPE_BIND_ERROR(333, "参数类型错误"),
    PARAM_IS_MISSING(334, "参数缺失"),


    // 4++：请求错误
    FAILURE(400, "失败"),


    // 5++：系统错误
    ERROR(500, "服务器错误"),
    DATABASE_ERROR(502, "数据库出错"),
    SERVICE_IS_INVALID(503, "服务无效或未启用"),
    SYSTEM_INNER_ERROR(504, "系统繁忙，请稍后重试"),


    // 6++ 业务错误
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(601, "某业务出现问题"),
    RESULT_DATA_NONE(602, "数据未找到"),
    DATA_IS_WRONG(603, "数据有误"),
    DATA_ALREADY_EXIST(604, "数据已存在"),
    DATA_NOT_EXIST(605, "数据不存在"),
    // 数据操作错误
    DATA_ADD_ERROR(607, "数据添加失败"),
    DATA_ALREADY_ADDED(608, "重复添加数据"),
    DATA_DELETE_ERROR(609, "数据删除失败"),
    DATA_UPDATE_ERROR(610, "数据更新失败"),
    DATA_GET_ERROR(613, "数据获取失败"),
    DATA_FIND_ERROR(614, "数据查找失败"),

    DATA_BATCH_PROCESS_ERROR(620, "数据批量操作失败"),
    DATA_BATCH_ADD_ERROR(621, "数据批量添加失败"),
    DATA_BATCH_DELETE_ERROR(622, "数据批量删除失败"),
    DATA_BATCH_UPDATE_ERROR(623, "数据批量更新失败"),

    SYNCHRONOUS_DATA_ERROR(625, "数据更新同步失败"),
    IMPORT_DATA_ERROR(627, "数据导入失败"),

    /* 7++ 权限错误 */
    PERMISSION_NO_ACCESS(701, "无访问权限");


    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultCode(boolean bool, String message) {
        this.code = bool ? 200 : 400;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
