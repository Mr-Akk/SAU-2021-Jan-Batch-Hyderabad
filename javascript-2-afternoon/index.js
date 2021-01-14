// Custom Reduce Function

let customAccum = (arr, callBack) => {
  let result = 0;
  for (let i = 0; i < arr.length; i++) {
    result = callBack(result, arr[i]);
  }
  return result;
};

let arr = [2, 2, 2];
let ans = customAccum(arr, (acc, val) => {
  return acc + val;
});

console.log(ans);

// var a = 100;
// function aa() {
//   b = 10;
//   function c() {
//     console.log(b);
//   }
//   c();
// }
// aa();

// let a = function () {
//   console.log(this);
// };
// let aa = () => {
//   console.log(this);
// };
// function aaa() {
//   console.log(this);
// }
// a();
// aa();
// aaa();

// let b = a.map((i) => {});

// function customMap(arr, fn) {
//   let a = [];
//   for (var i = 0; i < arr.length; i++) {
//     a.push(fn(i));
//   }
//   return a;
// }
// var a = [1, 2, 3, 4, 5];
// let ans = customMap(a, (i) => i ** 2);
// console.log(ans);
