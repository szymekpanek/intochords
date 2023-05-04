const notes = ["C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"];
const gameBoard = document.getElementById("game-board");
const checkBtn = document.getElementById("check-btn");
const playAgainBtn = document.getElementById("play-again-btn");
const resultPopup = document.getElementById("result-popup");
const closeResultPopup = document.getElementById("close-result-popup");


let matrix = [];
let userMatrix = [];

function createMatrix() {
    const randomNoteIndex = Math.floor(Math.random() * notes.length);
    const randomNote = notes[randomNoteIndex];

    matrix = [
        [randomNote, notes[(randomNoteIndex + 4) % notes.length], notes[(randomNoteIndex + 7) % notes.length]],
        [notes[(randomNoteIndex + 8) % notes.length], randomNote, notes[(randomNoteIndex + 3) % notes.length]],
        [notes[(randomNoteIndex + 5) % notes.length], notes[(randomNoteIndex + 9) % notes.length], randomNote]
    ];

    userMatrix = [
        [randomNote, "", ""],
        ["", randomNote, ""],
        ["", "", randomNote]
    ];

    renderMatrix();
    
}

function renderMatrix() {
    gameBoard.innerHTML = "";

    userMatrix.forEach((row, rowIndex) => {
        row.forEach((cell, cellIndex) => {
            const cellDiv = document.createElement("div");
            cellDiv.classList.add("cell");

            const input = document.createElement("input");
            input.classList.add("note-input");
            input.value = cell;
            input.maxLength = 2;
            input.addEventListener("input", (event) => handleCellInput(event, rowIndex, cellIndex));

            cellDiv.appendChild(input);
            gameBoard.appendChild(cellDiv);
        });
    });
}


function handleCellInput(event, rowIndex, cellIndex) {
    const userNote = event.target.value;

    if (notes.includes(userNote)) {
        userMatrix[rowIndex][cellIndex] = userNote;
    } else if (!userNote) {
        userMatrix[rowIndex][cellIndex] = "";
    } else {
        event.target.value = userMatrix[rowIndex][cellIndex];
        alert("Invalid note. Please enter a valid note.");
    }
}

function checkMatrix() {
    let allCorrect = true;

    userMatrix.forEach((row, rowIndex) => {
        row.forEach((cell, cellIndex) => {
            const cellDiv = gameBoard.children[rowIndex * 3 + cellIndex];
            const input = cellDiv.querySelector(".note-input");

            if (cell === matrix[rowIndex][cellIndex]) {
                cellDiv.classList.add("correct");
                input.classList.add("correct");
            } else {
                cellDiv.classList.add("incorrect");
                input.classList.add("incorrect");
                allCorrect = false;
            }
        });
    });

    if (allCorrect) {
        setTimeout(() => {
            alert("You won!");
        }, 100);
    } else {
        setTimeout(() => {
            Array.from(gameBoard.querySelectorAll(".cell")).forEach(cell => {
                cell.classList.remove("correct");
                cell.classList.remove("incorrect");
            });
            Array.from(gameBoard.querySelectorAll(".note-input")).forEach(input => {
                input.classList.remove("correct");
                input.classList.remove("incorrect");
            });
        }, 2000);
    }
}
checkBtn.addEventListener("click", checkMatrix);
playAgainBtn.addEventListener("click", createMatrix);


createMatrix();

