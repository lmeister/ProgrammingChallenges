const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});


const operators = ['+', '-', ' '];
const expandoperators = ['+', '-', ' ', '*', '/'];

let digits = [];
for (let i = 1; i < 10; i++) {
  digits.push(i);
}


bruteforce(expandoperators)





const combinations = (arr, length) =>
    [...Array(length).keys()]
    .reduce(
        (result) =>
            arr.concat(result.flatMap((val) => arr.map((char) => val + char))),
        []
    )
    .filter((val) => val.length >= length);


function bruteforce(ops) {
  rl.question('Value?', function(value) {
    const res = combinations(ops, 8);

    let expression = '';
    let counter = 0;
    for(let j = 0; j < res.length; j++) {
      counter++;
      expression = "";

      for (let i = 0; i < 8; i++) {
        expression += ((i+1).toString() + res[j][i]);
      }
      expression += 9;

      expression = expression.replace(/\s+/g, "");

      if (eval(expression) == value) {
        break;
      }
    }
    console.log('Wiederholungen: ' + counter + '\nExpression: ' + expression);
    rl.close();
  });
}