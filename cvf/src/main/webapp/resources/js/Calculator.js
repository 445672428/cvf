/**
 * 
 * @param {*} expre  计算表达式
 * @param {*} val    计算表达式对应的数值
 */

(function (global, factory) {

    global.Calculator = factory();
}(this, (function () {
    function unique(array) {
        var n = {},
            r = [],
            len = array.length,
            val, type;
        for (var i = 0; i < array.length; i++) {
            if (array[i] == "") {
                continue;
            }
            val = array[i];
            type = typeof val;
            if (!n[val]) {
                n[val] = [type];
                r.push(val);
            } else if (n[val].indexOf(type) < 0) {
                n[val].push(type);
                r.push(val);
            }
        }
        return r;
    }

    function doEpress(str, obj) {


        var charArray = str.split(""),
            code = 97,
            temp = "",
            newExpress = "",
            i = 0;

        for (var index = 0; index < charArray.length; index++) {
            var ch = charArray[index];
            if(ch == ""){
                continue;
            }
            if (ch == '*' || ch == '(' || ch == ')' || ch == '+' || ch == '/' || ch == '-') {
                if (temp == "") {
                    newExpress += ch;
                    continue;
                }
                if (isNaN(temp * 1)) {
                    newExpress += temp
                } else {
                    var c = String.fromCharCode(code + i);
                    obj[c] = temp * 1;
                    newExpress += c
                    i++;
                }
                newExpress += ch;
                temp = "";
            } else {
                temp += charArray[index];
                if (index == charArray.length - 1) {
                    if (isNaN(temp * 1)) {
                        newExpress += temp
                    } else {
                        var c = String.fromCharCode(code + i);
                        obj[c] = temp * 1;
                        newExpress += c
                        i++;
                    }
                }
            }
        }

        return {
            express: newExpress,
            map: obj
        }
    }

    function repExpress(str) {
        if (!str || str == '') {
            return
        }
        if (typeof str != 'string') {
            return;
        }
        //提取所有的数据点 replace(/[^a-zA-Z0-9]/g," ")
        var nstr = str.replace(/[^a-zA-Z0-9]/g, "#");
        var strs = nstr.split("#");
        //对数组去重
        strs = unique(strs);

        //用abc 替换baseid
        var obj = {},
            code = 65;
        for (var i = 0; i < strs.length; i++) {
            var ch = String.fromCharCode(code + i);
            var bse = strs[i];
            obj[ch] = strs[i];
            obj[bse] = ch;
        }
        var charArray = str.split("");
        var temp = "";
        var newExpress = "";
        for (var index = 0; index < charArray.length; index++) {
            var ch = charArray[index];
            if (ch == '*' || ch == '(' || ch == ')' || ch == '+' || ch == '/' || ch == '-') {
                if (temp == "") {
                    newExpress += ch;

                    continue;
                }
                newExpress += obj[temp]
                newExpress += ch;
                temp = "";
            } else {
                temp += charArray[index];
                if (index == charArray.length - 1) {
                    newExpress += obj[temp];
                }
            }
        }

        return {
            express: newExpress,
            map: obj
        };

    }

    function Stack() {
        this.dataStore = [];
        this.top = 0;
        this.push = push;
        this.pop = pop;
        this.peek = peek;
        this.clear = clear;
        this.length = length;
        this.printElement = printStack;

        //注意++操作符的位置，它放在this.top的后面，这样新入栈的元素就被放在top的当前位置对应的位置，同时top自加1，指向下一个位置
        function push(element) {
            this.dataStore[this.top++] = element;
        }
        //返回栈顶元素，同时top的位置减1
        function pop() {
            return this.dataStore[--this.top];
        }
        //peek()方法返回数组的第top-1个位置的元素，即栈顶元素
        function peek() {
            return this.dataStore[this.top - 1];
        }
        //将top的值设置0，即清空一个栈
        function clear() {
            this.top = 0;
        }
        //返回变量top的值即为栈内元素的个数
        function length() {
            return this.top;
        }

        //输出栈内元素
        function printStack() {
            while (this.top > 0) {
                document.writeln(this.pop() + "&nbsp;&nbsp;");
            }
        }
    }

    function suffixExpression(str) {

        var stack = new Stack();
        var outStack = new Array();
        for (var i = 0; i < str.length; ++i) {
            if (')' == str[i]) {
                while (true) {
                    var top = stack.peek();
                    stack.pop();
                    if ('(' != top) {
                        outStack[outStack.length] = top;
                    } else {
                        break;
                    }
                }
            } else if (['-', '+'].indexOf(str[i]) > -1) {
                if (['*', '/'].indexOf(stack.peek()) > -1) {
                    while (['*', '/'].indexOf(stack.peek()) > -1) {
                        outStack[outStack.length] = stack.peek();
                        stack.pop();
                    }
                    outStack[outStack.length] = str[i];
                } else {
                    stack.push(str[i]);
                }
            } else if (['(', '*', '/'].indexOf(str[i]) > -1) {
                stack.push(str[i]);
            } else {
                outStack[outStack.length] = str[i];
            }
        }
        while (true) {
            var top = stack.peek();
            stack.pop();
            if (top != undefined) {
                outStack[outStack.length] = top;
            } else {
                break;
            }
        }
        return outStack;
    }


    function countSuffixExpression(str, map, val) {

        var stack = new Stack();
        for (var i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '*' || str[i] == '/' || str[i] == '-') {
                var a = stack.pop();
                var b =  stack.pop();
                stack.push(eval(b + str[i] + a));
                
            } else {
                var curVal = str[i];
                var baseid2 = map[curVal];
                stack.push(val[baseid2] || 0)
            }
        }
        return stack.pop();
    }


    function countSuffixExpressionArith(str,val) {

        var stack = new Stack();
        for (var i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '*' || str[i] == '/' || str[i] == '-') {
                var a = stack.pop();
                var b =  stack.pop();
                stack.push(eval(b + str[i] + a));
            } else {
                var key = str[i];
                stack.push(val[key]);
            }
        }
        return stack.pop();
    }

    function Calculator() {}
    Calculator.prototype.clAlgebra = function (expre, val) {
        var obj1  = doEpress(expre,val)
        var obj = repExpress(obj1.express);
        var newE = suffixExpression(obj.express);
        var res = countSuffixExpression(newE.join(""), obj.map, obj1.map);
        return res;
    }
    Calculator.prototype.calArith = function (str) {
        var obj =  doEpress(str,{})
        var express = suffixExpression(obj.express)

        return countSuffixExpressionArith(express.join(""), obj.map);
    }

    return new Calculator();


})))