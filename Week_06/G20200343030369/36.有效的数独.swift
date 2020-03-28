/*
 * @lc app=leetcode.cn id=36 lang=swift
 *
 * [36] 有效的数独
 *
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (58.24%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    62.7K
 * Total Submissions: 106.6K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 
 * 
 * 上图是一个部分填充的有效的数独。
 * 
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * ⁠    但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 
 * 说明:
 * 
 * 
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */

// @lc code=start
class Solution {
    func isValidSudoku(_ board: [[Character]]) -> Bool {
        
    }

    func isValidSudokuIteration(_ board: [[Character]]) -> Bool {
        let rows = Array(repeating: [Character: Int](), count: 9)
        let columns = Array(repeating: [Character: Int](), count: 9)
        let indexBox = Array(repeating: [Character: Int](), count: 9)
        for i in 0..<9 {
            for j in 0..<9 where board[i][j] != "." {
                let c = board[i][j]
                var row = rows[i]
                if let _ = row[c] {
                    return false
                } else {
                    row[c] = 1
                    // rows[i] = row
                }

                var column = columns[j]
                if let _ = column[c] {
                    return false
                } else {
                    column[c] = 1
                    // columns[j] = column
                }

                let index = (i / 3) * 3 + j / 3
                var box = indexBox[index]
                if let _ = box[c] {
                    return false
                } else {
                    box[c] = 1
                    // indexBox[index] = box
                }
            }
        }
        return true
    }

    func isValidSudokuOptimal(_ board: [[Character]]) -> Bool {
        var rows = Array(repeating: Set<Character>(), count: 9)
        var columns = Array(repeating: Set<Character>(), count: 9)
        var boxes = Array(repeating: Set<Character>(), count: 9)
        for i in 0..<9 {
            for j in 0..<9 {
                let v = board[i][j]
                guard v != "." else {continue}
                let index = (i / 3) * 3 + j / 3
                guard !rows[i].contains(v) && !columns[j].contains(v) && !boxes[index].contains(v) else {
                    return false
                }

                rows[i].insert(v)
                columns[j].insert(v)
                boxes[index].insert(v)
            }
        }
    }
}
// @lc code=end

