// 190. 颠倒二进制位 https://leetcode-cn.com/problems/reverse-bits/
// 颠倒给定的 32 位无符号整数的二进制位。
/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
  var num = 0b0;
  for (var i = 0; i <= 31; i++) {
    num |= (((n >> (31 - i)) & 1) << i) >>> 0;
  }
  return num >>> 0;
};
var reverseBits = function(n) {
  let result = 0;
  for (let i = 0; i < 32; i++) {
    result = (result << 1) + (n & 1);
    n >>= 1;
  }
  return result >>> 0;
};
var reverseBits = function(n) {
  let result = 0;
  // result从右往移动空出末位 + n从左往右移动获取末位 + n次 = 倒序
  for (let i = 0; i < 32; i++) {
    // 左移空出一位
    result <<= 1;
    // n&1获取n的末位，result的末位换成n的末位
    result |= n & 1;
    // 右移1位
    n >>= 1;
  }
  return result >>> 0;
};
