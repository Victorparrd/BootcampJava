$(document).ready(function () {
    $("#loadCharacters").click(function () {
        $.ajax({
            url: 'https://rickandmortyapi.com/api/character',
            method: 'GET',
            success: function (characters) {
                var tableBody = $(".table-group-divider");
                tableBody.empty();

                characters.results.forEach(function (character) {
                    var row = $("<tr>");
                    var nameCell = $("<td>").text(character.name);
                    var photoCell = $("<td>").append($("<img>").attr("src", character.image).attr("alt", character.name));
                    var statusCell = $("<td>").text(character.status);
                    var specieCell = $("<td>").text(character.species);

                    row.append(nameCell);
                    row.append(photoCell);
                    row.append(statusCell);
                    row.append(specieCell);

                    tableBody.append(row);
                });
            },
        });
    });
});
