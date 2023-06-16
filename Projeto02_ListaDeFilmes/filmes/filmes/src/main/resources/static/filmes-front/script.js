function fetchAndDisplayMovies() { 
  fetch('http://localhost:8080/movie')
    .then(function(response) {
      return response.json();
    })
    .then(function(data) {
      var tableBody = document.querySelector('#moviesTable tbody');
      tableBody.innerHTML = '';

      if (data.length === 0) {
        var emptyRow = document.createElement('tr');
        var emptyCell = document.createElement('td');
        emptyCell.setAttribute('colspan', '4');
        emptyCell.textContent = 'Nenhum filme encontrado'; //Importante salientar que se o banco estiver vazio, o conteúdo da celula é que não encontrou nenhum filme
        emptyRow.appendChild(emptyCell);
        tableBody.appendChild(emptyRow);
      } else {
        data.forEach(function(movie) {
          var row = document.createElement('tr');
          row.innerHTML = `
            <td>${movie.id}</td>
            <td>${movie.movieTitle}</td>
            <td>${movie.movieGenre}</td>
            <td>${movie.movieYear}</td>
          `;
          tableBody.appendChild(row);
        });
      }
    })
    .catch(function(error) {
      console.error('Erro ao obter filmes:', error); //Se houver algum erro, ele tem que nos informar que não conseguiu obter os filmes!
      alert('Erro ao obter filmes');
    });
}

document.getElementById('addMovieForm').addEventListener('submit', function(e) { //Basicamente esse é o método para adicionar os filmes no banco
  e.preventDefault();

  var movieTitle = document.getElementById('movieTitle').value;
  var movieGenre = document.getElementById('movieGenre').value;
  var movieYear = document.getElementById('movieYear').value;

  if (!movieTitle || !movieGenre || !movieYear) {
    alert('Por favor, preencha todos os campos'); //Alerta para preencher os campos caso o usuário não tenha preenchido
    return;
  }

  var movieData = {
    movieTitle: movieTitle,
    movieGenre: movieGenre,
    movieYear: parseInt(movieYear)
  };

  fetch('http://localhost:8080/movie', {
    method: 'POST', //Método HTTP POST fazendo comunicação com o Back e com o BD
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(movieData)
  })
    .then(function() {
      alert('Filme adicionado com sucesso'); //Se der tudo certo, o filme é adicionado
      document.getElementById('movieTitle').value = '';
      document.getElementById('movieGenre').value = '';
      document.getElementById('movieYear').value = '';

      fetchAndDisplayMovies(); // Atualiza a tabela de filmes após adicionar um novo filme
    })
    .catch(function(error) {
      console.error('Erro ao adicionar filme:', error); //Se não der certo, o programa é obrigado a nos mostrar um erro.
      alert('Erro ao adicionar filme');
    });
});

fetchAndDisplayMovies(); // Busca e exibe os filmes ao carregar a página
