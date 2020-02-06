// card flip effect
function flip() {
    var element = event.currentTarget;
    if (element.className === "card") {
        if (element.style.transform == "rotateY(180deg)") {
            element.style.transform = "rotateY(0deg)";
        } else {
            element.style.transform = "rotateY(180deg)";
        }
    }
}
// Switch to the word game screen
function word() {
    var main = document.getElementById('main');
    var word = document.getElementById('word');
    var number = document.getElementById('number');
    var replay = document.getElementById('replay');
    main.style.display = 'none';
    word.style.display = 'block';
    number.style.display = 'none';
    replay.style.display = 'none';
}
// Switch to the number game screen
function number() {
    var main = document.getElementById('main');
    var word = document.getElementById('word');
    var number = document.getElementById('number');
    var replay = document.getElementById('replay');
    main.style.display = 'none';
    word.style.display = 'none';
    number.style.display = 'block';
    replay.style.display = 'none';
}
// Switch to the replay screen
function replay() {
    var main = document.getElementById('main');
    var word = document.getElementById('word');
    var number = document.getElementById('number');
    var replay = document.getElementById('replay');
    main.style.display = 'none';
    word.style.display = 'none';
    number.style.display = 'none';
    replay.style.display = 'block';
}
// Switch to the home screen
function home() {
    var main = document.getElementById('main');
    var word = document.getElementById('word');
    var number = document.getElementById('number');
    var replay = document.getElementById('replay');
    main.style.display = 'block';
    word.style.display = 'none';
    number.style.display = 'none';
    replay.style.display = 'none';
}
