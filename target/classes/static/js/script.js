const nome = document.getElementById("nome");
const cpf = document.getElementById("cpf");
const senha = document.getElementById("senha");
const cadastrar = document.getElementById("cadastrar");
const numero = document.getElementById("numero");
const complemento = document.getElementById("complemento");

const formOuvidor = document.getElementById("formOuvidor");
const ouvidor = document.getElementById("ouvidor")
const cidadao = document.getElementById("cidadao")

const form = document.getElementById("form");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  checkInput();
});

function checkMark() {
  cidadao.checked === true ? form.className = "row g-3 border rounded" : form.className = "d-none"
  ouvidor.checked === true ? formOuvidor.className = "row g-3 border rounded" : formOuvidor.className = "d-none"
  

}

function checkInput() {
  const nomeValue = nome.value.trim();
  const cpfValue = cpf.value.trim();
  const senhaValue = senha.value.trim();
  const numeroValue = numero.value.trim();
  const complementoValue = complemento.value.trim();

  nomeValue === "" ? error("nome", "Preencher com seu Nome") : sucesso("nome");
  TestaCPF(cpfValue) === false ? error("cpf", "CPF invalido") : sucesso("cpf");
  senhaValue.length <= 7
    ? error("senha", "Senha menor que 8 caracteres")
    : sucesso("senha");
  numeroValue === "" ? error("numero", "Campo obrigatorio") : sucesso("numero");
  complementoValue === ""
    ? error("complemento", "Campo obrigatorio")
    : sucesso("complemento");
}

function error(input, msg) {
  const formControl = document.getElementById(`${input}`);
  console.log(formControl);

  formControl.className = "form-control border-danger";
  formControl.placeholder = msg;
}

function sucesso(input) {
  const formControl = document.getElementById(`${input}`);
  formControl.className = "form-control border-success";
}
function TestaCPF(strCPF) {
  let Soma = 0;
  let Resto;
  let i;

  switch (strCPF) {
    case "00000000000":
    case "11111111111":
    case "22222222222":
    case "33333333333":
    case "44444444444":
    case "55555555555":
    case "66666666666":
    case "77777777777":
    case "88888888888":
    case "99999999999":
      return false;
  }

  for (i = 1; i <= 9; i++)
    Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
  Resto = (Soma * 10) % 11;

  if (Resto == 10 || Resto == 11) Resto = 0;
  if (Resto != parseInt(strCPF.substring(9, 10))) return false;

  Soma = 0;
  for (i = 1; i <= 10; i++)
    Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
  Resto = (Soma * 10) % 11;

  if (Resto == 10 || Resto == 11) Resto = 0;
  if (Resto != parseInt(strCPF.substring(10, 11))) return false;
  return true;
}
