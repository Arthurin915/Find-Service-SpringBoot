$(function () {
     $('a[href="#search"]').on('click', function(event) {
         event.preventDefault();
         $('#search').addClass('open');
          
         
         $('#search > form > input[type="search"]').focus();
     });
    
     
     $('#search, #search button.close').on('click keyup', function(event) {
         if (event.target == this || event.target.className == 'close' || event.keyCode == 27) {
              $(this).removeClass('open');
          }
      });
   
      $('body').on('submit', '#pesquisar', function(){
      	$('#search').removeClass('open');
      	$.ajax({
     		method: 'GET',
     		url: '/pessoa/' + $('#pesq').val()
     	}).done(function (data) {
 			var table = $('#example').DataTable();
 			table.clear();
 			
     		for (var i = 0; i < data.length; i++) {
     			var botao = $("<button>");
     			botao.addClass('visualiza');
     			botao.text("Visualizar");
     			botao.attr('data-endereco', constroiEndereco(data[i]));
     			
     			table.row.add([
     				data[i].nome,
     				data[i].email,
     				constroiEndereco(data[i]),
     				data[i].telefone,
     				botao[0].outerHTML
     			]).draw();
     		}
      	});
      	return false;
      });   
   
      $('#example').on('click', '.visualiza', function (e) {
      	var endereco = $(e.target).data('endereco');
      	trocarPosicao(endereco);
     });
 });
 
 function constroiEndereco(data) {
 	return data.endereco + ", " + data.numero + ", " + data.cidade
 }