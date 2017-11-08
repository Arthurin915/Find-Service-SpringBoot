$(function () {
    $('a[href="#search"]').on('click', function (event) {
        event.preventDefault();
        $('#search').addClass('open');


        $('#search > form > input[type="search"]').focus();
    });


    $('#search, #search button.close').on('click keyup', function (event) {
        if (event.target == this || event.target.className == 'close' || event.keyCode == 27) {
            $(this).removeClass('open');
        }
    });

    $('body').on('submit', '#pesquisar', function () {
        $('#search').removeClass('open');
        $.ajax({
            method: 'GET',
            url: '/pessoa/' + $('#pesq').val()
        }).done(function (data) {
            resetMap();
            mostraNaTabela(data);
        });
        return false;
    });

    $('#example').on('click', '.visualiza', function (e) {
        var endereco = $(e.target).data('endereco');
        centralizarEmpresa(endereco);
    });

    $('body').on('submit', '#pesquisa-categoria', function () {
        $('#FormPesquisa').modal('hide');
        $.ajax({
            method: 'GET',
            url: '/busca/' + $('#Categoria').val()
        }).done(function (data) {
            resetMap();
            mostraNaTabela(data);
        });
        return false;
    });
});

function constroiEndereco(data) {
    return data.endereco + ", " + data.numero + ", " + data.cidade
}

function mostraNaTabela(data) {
    var table = $('#example').DataTable();
    table.clear();

    for (var i = 0; i < data.length; i++) {
        var botao = $("<button>");
        botao.addClass('visualiza');
        botao.text("Visualizar");

        var enderecos = '';

        for (var j = 0; j < data[i].enderecos.length; j++) {
            enderecos += constroiEndereco(data[i].enderecos[j]) + ', ';
        }

        enderecos = enderecos.substr(0, enderecos.length - 2);

        botao.attr('data-endereco', enderecos);
        botao.attr('data-nome', data[i].nome);
        botao.attr('data-cnpj', data[i].cnpj);
        botao.attr('data-cep', data[i].cep);
        botao.attr('data-email', data[i].email);
        botao.attr('data-telefones', JSON.stringify(data[i].telefones));
        botao.attr('data-nota', data[i].nota);
        botao.attr('data-descricao', data[i].descricao);

        var telefones = '';

        for (var j = 0; j < data[i].telefones.length; j++) {
            telefones += data[i].telefones[j].numero + ', ';
        }

        telefones = telefones.substr(0, telefones.length - 2);

        table.row.add([
            data[i].nome,
            data[i].email,
            enderecos,
            telefones,
            botao[0].outerHTML
        ]).draw();

        trocarPosicao(constroiEndereco(data[i].enderecos[0]), data[i].nome, data[i].cnpj, data[i].email, data[i].cep, data[i].telefones, data[i].nota, data[i].descricao);
    }
}