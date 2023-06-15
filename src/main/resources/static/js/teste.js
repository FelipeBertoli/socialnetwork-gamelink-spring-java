fetch('/getAllUsers')
  .then(response => response.json())
  .then(data => {
    // 'data' contém o JSON retornado pela API
    console.log(data);
    // Faça algo com os dados JSON aqui
  })
  .catch(error => {
    console.error('Ocorreu um erro:', error);
  });
