$('#InputUsuarioConfirmar').blur(function(){
	if($('#InputUsuarioConfirmar').val() == $('#InputUsuarioSenha').val()){
		alert('Certo');
		$('#btn-salvar-usuario').attr('disabled',false);
	}else {
		$('#btn-salvar-usuario').attr('disabled',true);
	}
});

