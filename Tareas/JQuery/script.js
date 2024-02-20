$(document).ready(function () {
    $("#loadCharacters").click(function () {
        $.ajax({
            url: 'https://rickandmortyapi.com/api/character',
            method: 'GET',
            success: function (characters) {
                var characterList = $("#characterList");
                characterList.empty();

                characters.results.forEach(function (character) {
                    var li = $("<li>").text(character.name + " - " + character.species);
                    characterList.append(li);
                });
            },
        });
    });
});
