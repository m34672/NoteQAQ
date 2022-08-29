onmessage = function (e) {
  let number = e.data;
  setInterval(function () {
    number--;
    postMessage(number);
  }, 1000);
};
