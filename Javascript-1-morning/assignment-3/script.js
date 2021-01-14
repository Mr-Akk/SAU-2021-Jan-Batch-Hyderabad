document.getElementById("submit").addEventListener("click", () => {
  var num1 = +document.getElementById("num1").value;
  var num2 = +document.getElementById("num2").value;
  var ans = num1 + num2;
  document.getElementById("result").disabled = false;
  document.getElementById("result").value = ans;
  document.getElementById("num1").value = "";
  document.getElementById("num2").value = "";
});

function reset() {
  document.getElementById("result").value = "";
}
document.getElementById("num1").addEventListener("change", reset);
document.getElementById("num2").addEventListener("change", reset);
