$(document).ready(function() {

  // Iniciando tabela
  inicializandoTela();

  $("#btn_salvar").click(function() {
    var settings = {
      "url": "http://localhost:8080/api/aeronave",
      "method": "POST",
      "timeout": 0,
      "headers": {
        "Content-Type": "application/json",
      },
      "data": JSON.stringify({"nome":$("#aeronave").val(),
                              "marca":$("#marca").val(),
                              "descricao":"Cadastro de aeronave utilizando API",
                              "vendido":$("#vendido").val(),
                              "ano":$("#ano").val()}),
    };

    // Verifica se todos os dados estão preenchidos
    if ($("#aeronave").val() == "" ||
        $("#marca").val() == "" ||
        $("#ano").val() == "" ||
        $("#vendido").val() == "default" ||
        $("#marca").val() == "default") {
      alert("Campos obrigatórios necessários");
      return true;
    } else {
      $.ajax(settings)
      .done(function (response) {
        alert("Item salvo com sucesso");
      })
      .fail(function() {
        alert( "Erro ao acessar a API" );
      })
      .always(function() {
        // Reload informações da tela
        inicializandoTela();
        // Limpando os campos da tela
        $("#aeronave").val("");
        $("#ano").val("");
        $("#vendido").val("default");
        $("#marca").val("default");
      });
    }
  });

});

// Chamando funções para inicializar a tela
function inicializandoTela() {
  // Montando a tabela
  montaTabela();
  montaInfo();
  montaInforEmpresas();
}

// Função para montar a tabela de aeronaves
function montaTabela() {
  var settings = {
    "url": "http://localhost:8080/api/aeronave",
    "method": "GET",
    "timeout": 0,
    "headers": {
      "Content-Type": "application/json"
    },
  };

  $.ajax(settings).done(function (response) {
    var html = "";

    $.each(response, function(ind, val) {
      html += "<tr>" +
                "<td>" + val.id + "</td>" +
                "<td>" + val.marca + "</td>" +
                "<td>" + val.nome + "</td>" +
                "<td>" + val.ano + "</td>" +
                "<td>" + (val.vendido ? "Sim" : "Não") + "</td>" +
                "<td><button type='button' class='btn btn-primary' onclick='excluir_aeronave(" + val.id + ")'>Excluir</button></td>" +
              "</tr>";
    });

    $("#corpo_table").html(html);
  });
}

// Função para excluir uma aeronave
function excluir_aeronave(id) {
  var settings = {
    "url": "http://localhost:8080/api/aeronave/"+ id,
    "method": "DELETE",
    "timeout": 0,
  };

  $.ajax(settings)
    .done(function (response) {
      alert("Item excluido");
    })
    .fail(function() {
      alert( "Erro ao acessar a API" );
    })
    .always(function() {
      // Recarregando informações da tela
      inicializandoTela();
    });
}

// Função que monta informações Fixas na tela
function montaInfo() {
  var settings = {
    "url": "http://localhost:8080/api/aeronave/info",
    "method": "GET",
    "timeout": 0,
  };

  $.ajax(settings).done(function (response) {
    $("#dec_90").html(response.anos_noventa);
    $("#dec_00").html(response.anos_dois_mil);
    $("#dec_now").html(response.ano_now);
  });
}

// Função que monta as informações por empresa
function montaInforEmpresas() {
  var settings = {
    "url": "http://localhost:8080/api/aeronave/porEmpresa",
    "method": "GET",
    "timeout": 0,
  };

  $.ajax(settings).done(function (response) {
    var html = "";
    $.each(response, function(ind, val) {
      html += "<p>" + val.empresa + ": " + val.qtd + "</p>";
    });

    $("#info_empresas").html(html);
  });
}
