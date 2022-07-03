package astoyw.kai.demobank.common.enums;


import lombok.Getter;

/**
 *
 * @Description 状态码定义约束，共6位数，前三位代表服务，后4位代表接口
 *  比如 商品服务210,购物车是220、用户服务230，403代表权限
 *
 **/
public enum BizCodeEnum {
    /**
     * 通用操作码
     */
    OPS_REPEAT(110001,"重复操作"),

    /**
     *验证码
     */
    CODE_TO_ERROR(240001,"接收号码不合规"),
    CODE_LIMITED(240002,"验证码发送过快"),
    CODE_ERROR(240003,"验证码错误"),
    CODE_CAPTCHA(240101,"图形验证码错误"),



    /**
     * 账号
     */
    ACCOUNT_REPEAT(250001,"账号已经存在"),
    ACCOUNT_UNREGISTER(250002,"账号不存在"),
    ACCOUNT_PWD_ERROR(250003,"账号或者密码错误"),
    ACCOUNT_LOGIN_STATE(250004,"账号已登陆，如不是本人，请联系管理员。"),
    ACCOUNT_STATE(250005,"账号未激活，请联系管理员。"),
    ACCOUNT_NAMEADNPWDNULL(250006,"账号或密码不可为空"),
    ACCOUNT_UPDATEISNULL(250007,"修改对象不可为空"),
    ACCOUNT_UNLOGIN(250008,"账号已过期，请重新登录。"),
    ACCOUNT_EMAIL(250009,"邮箱格式错误！"),


    /**
     * 订单
     */
    ORDER_CONFIRM_COUPON_FAIL(280001,"创建订单-优惠券使用失败,不满足价格条件"),
    ORDER_CONFIRM_PRICE_FAIL(280002,"创建订单-验价失败"),
    ORDER_CONFIRM_LOCK_PRODUCT_FAIL(280003,"创建订单-商品库存不足锁定失败"),
    ORDER_CONFIRM_ADD_STOCK_TASK_FAIL(280004,"创建订单-新增商品库存锁定任务"),
    ORDER_CONFIRM_TOKEN_NOT_EXIST(280008,"订单令牌缺少"),
    ORDER_CONFIRM_TOKEN_EQUAL_FAIL(280009,"订单令牌不正确"),
    ORDER_CONFIRM_NOT_EXIST(280010,"订单不存在"),
    ORDER_CONFIRM_CART_ITEM_NOT_EXIST(280011,"购物车商品项不存在"),

    /**
     * 收货地址
     */
    ADDRESS_ADD_FAIL(290001,"新增收货地址失败"),
    ADDRESS_DEL_FAIL(290002,"删除收货地址失败"),
    ADDRESS_NO_EXITS(290003,"地址不存在"),

    /**
     * 支付
     */
    PAY_ORDER_FAIL(300001,"创建支付订单失败"),
    PAY_ORDER_CALLBACK_SIGN_FAIL(300002,"支付订单回调验证签失败"),
    PAY_ORDER_CALLBACK_NOT_SUCCESS(300003,"支付宝回调失败"),
    PAY_ORDER_NOT_EXIST(300005,"订单不存在"),
    PAY_ORDER_STATE_ERROR(300006,"订单状态不正常"),
    PAY_ORDER_PAY_TIMEOUT(300007,"订单支付超时"),

    /**
     * 数据库操作
     */

    SQL_ADD_USER_ERROR(400001,"添加用户失败"),
    SQL_UPDATE_USER_ERROR(400002,"修改用户失败"),
    SQL_DEL_ERROR(400003,"删除失败"),
    SQL_ADD_ERROR(400004,"添加失败"),
    SQL_UPDATE_ERROR(400005,"修改失败"),
    SQL_UPDATE_PURCHASE_ORDER_ERROR(400006,"确认完成采购订单失败"),
    SQL_UPDATE_STORAGE_NUM_ERROR(400007,"更新库存数量失败"),
    SQL_UPDATE_PUSH_ORDER_ERROR(400008,"确认完成出库订单失败"),
    SQL_ADD_CAR_STORAGE_ERROR(400009,"添加车辆库存信息失败"),

    /**
     *  权限
     */
    AUTH_UN_ERROR(410001,"权限不足，拒绝访问"),

    /**
     * 业务
     */
    DATA_IS_NULL(420001,"时间对象不可为空"),
    BATCH_DEL_IS_NULL(420002,"批量删除对象不可为空"),
    ADD_OBJECT_IS_NULL(420003,"添加对象不可为空"),
    UPDATE_OBJECT_IS_NULL(420003,"修改对象不可为空"),
    DEL_OBJECT_IS_NULL(420003,"删除对象不可为空"),

    /**
     * 流控操作
     */

    CONTROL_FLOW(500101,"限流控制"),
    CONTROL_DEGRADE(500201,"降级控制"),
    CONTROL_AUTH(500301,"认证控制");


    @Getter
    private int code;
    @Getter
    private String message;

    private BizCodeEnum(int code , String message){
        this.code = code;
        this.message = message;
    }
}