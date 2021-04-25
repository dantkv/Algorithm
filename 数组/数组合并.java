/**
 * 数组合并
 * @param a 第一个参数
 * @param b 缺省数组参数
 */
public <T> T[] mergeArrayT(T[] a, T[] ...b) {
    int totalLength = a.length;
    for (T[] array : b) {
        totalLength += array.length;
    }
    T result[] = (T[]) newInstance(a.getClass().getComponentType(), totalLength);

    System.arraycopy(a, 0, result, 0, a.length);

    int offset = a.length;
    for (T[] array : b) {
        System.arraycopy(array, 0, result, offset, array.length);
        offset += array.length;
    }
    return result;
}