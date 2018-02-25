package com.xxscloud.core;



/**
 * 创建人: 李小双.
 * 创建时间:  2017/9/10.
 * 描述: 记录Log
 */
public final class Log {
//
//    /**
//     * 记录 Log .
//     */
//    private Log() {
//
//    }
//
//
//    /**
//     * Log 对象.
//     */
//    private static final Logger LOGGER;
//
//
//    static {
//        LOGGER = LoggerFactory.getLogger(Log.class);
//    }
//
//    /**
//     * 输出info .
//     *
//     * @param type    Class 类型
//     * @param message 消息内容
//     * @return 是否成功
//     */
//    public static boolean info(final Class<?> type, final String message) {
//        String text = type.toString() + " info: " + message;
//        LOGGER.info(text);
//        CompletableFuture.supplyAsync(() -> networksLog(text));
//        return true;
//    }
//
//    /**
//     * 输出 error .
//     *
//     * @param type      Class 类型
//     * @param exception 错误内容
//     * @return 是否成功
//     */
//    public static boolean error(final Class<?> type, final Exception exception) {
//        String text = type.toString() + " error: " + exception.getMessage();
//        LOGGER.error(text);
//        CompletableFuture.supplyAsync(() -> networksLog(text));
//        return true;
//    }
//
//    /**
//     * 输出 error .
//     *
//     * @param type      Class 类型
//     * @param exception 异常内容
//     * @param message   错误内容
//     * @return 是否成功
//     */
//    public static boolean error(final Class<?> type, final Exception exception, final String message) {
//        String text = type.toString() + " error: " + exception.getMessage() + " message: " + message;
//        LOGGER.error(text);
//        CompletableFuture.supplyAsync(() -> networksLog(text));
//        return true;
//    }
//
//    /**
//     * 输出 error .
//     *
//     * @param type    Class 类型
//     * @param message 错误内容
//     * @return 是否成功
//     */
//    public static boolean debug(final Class<?> type, final String message) {
//        String text = type.toString() + " debug: " + message;
//        LOGGER.debug(text);
//        CompletableFuture.supplyAsync(() -> networksLog(text));
//        return true;
//    }
//
//    /**
//     * 异步写入日志到服务器.
//     *
//     * @param message 消息内容
//     */
//    private static boolean networksLog(final String message) {
//        HttpUtils.put("", null, null);
//        return false;
//    }
}
