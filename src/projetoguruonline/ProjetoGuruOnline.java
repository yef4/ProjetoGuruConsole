package projetoguruonline;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;

// TRABALHO DO ALUNO MURILO TORRES E KAUÃ VALIM VERSÃO CONSOLE
public class ProjetoGuruOnline {

    public static void main(String[] args) {
        int test = 1;
        while (test != 0) {
        String name = "Oi Jeferson Leon,", sign = "tudo certo?", luckyColor = "Quando que esse X-calota vai acontecer?",
            dayTime = "A turma está questionando...";
        int gender = 0, age = 0, luckyNum = 0, time = 0, actYear;
        int maxDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int date[] = new int[3];
        Calendar today = Calendar.getInstance();
        actYear = today.get(Calendar.YEAR);
        time = today.get(Calendar.HOUR_OF_DAY);
        dayTime = getDayTime(time, dayTime);
        name = getName();
        gender = getGender();
        date = takeDate(maxDays, actYear);
        age = (int) showAge(date);
        sign = takeSign(date);
        luckyNum = takeLuckyNumber(luckyNum);
        luckyColor = takeLuckyColor(luckyColor);
        showResponse(name, dayTime, sign, gender, date, age, luckyNum, luckyColor);
        test = doQuestion();
        }
    }

    // Método com retorno em String, usado para ler cadeias de texto.
    public static String readText() {
        String text;
        Scanner read = new Scanner(System.in);
        text = read.nextLine();
        return text;
    }

    // Método com retorno em número inteiro, usado para ler números.
    public static int readInt() {
        int integer;
        Scanner read = new Scanner(System.in);
        integer = read.nextInt();
        return integer;
    }
   
    /* Método com retorno em String, para validar o nome do usuário e forçar o mesmo
    a escrever seu nome completo.*/
    public static String getName() {
        String name;
        System.out.println("\nDigite seu nome completo:");
        name = readText();
        while (name.length() <= 8) {
            System.out.println("Por favor, seu nome completo.");
            name = readText();
        }
        return name;
    }

    /*Método com retorno em número inteiro, usado para definir o gênero do usuário,
    e validar respostas incorretas.*/
    public static int getGender() {
        int gender;
        System.out.println("\nDigite seu gênero. \n1 para Feminino \n2 para Masculino");
        gender = readInt();
        if (gender == 1) {
            return 1;
        } else if (gender == 2) {
            return 2;
        } else {
            System.out.println("Sua resposta foi considerada como sendo do gênero masculino.");
            return 2;
        }
    }

    public static int[] takeDate(int maxDays[], int actYear){
        int isLeapYear;
        int date[] = new int[3];
        Boolean tDay, tMonth, tYear;
        System.out.println("\nDigite seu dia de nascimento:");
        date[0] = readInt();
       
        System.out.println("\nDigite seu mês de nascimento:");
        date[1] = readInt();
       
        System.out.println("\nDigite seu ano de nascimento:");
        date[2] = readInt();
        isLeapYear = testIfIsLeapYear(date[2]);
        if (isLeapYear == 1) {
            maxDays[1] = 29;
        } else {
            maxDays[1] = 28;
        }
        if (date[1] < 1 || date[1] > 12) {
            takeMonth(date);
        }
        tDay = (date[0] > 0 && date[0] <= maxDays[(date[1] - 1)]);
        tMonth = (date[1] >= 1 && date[1] <= 12);
        tYear = (date[2] > (actYear - 100) && date[2] <= actYear);
       
        if (tDay == false || tMonth == false || tYear == false){
            System.out.println("\nErro na data informada, favor re-digitar.");
            date = takeDate(maxDays, actYear);
        }

        return date;
    }

    /*Método com retorno em número inteiro, para validar o mês de Nascimento do
    usuário.*/
    public static int takeMonth(int date[]) {
        while (date[1] < 1 || date[1] > 12) {
            System.out.println("Erro, digite um mês válido.");
            date[1] = readInt();
        }
        return date[1];
    }

    /* Método com retorno em número inteiro, usado para validar se o ano de
    nascimento do usuário é um ano bissexto.*/
    public static int testIfIsLeapYear(int leapYear) {
        if (leapYear % 400 == 0) {
            leapYear = 1;
        } else if ((leapYear % 4 == 0) && (leapYear % 100 != 0)) {
            leapYear = 1;
        } else {
            leapYear = 0;
        }
        return leapYear;
    }

    /* Método com retorno em String, para definir o signo do usuário com base nos
    dados que ele informou.*/
    public static String takeSign(int date[]) {
        String sign = "não funcionou";
        if (date[0] >= 21 && date[1] == 3 || date[0] <= 20 && date[1] == 4) {
            sign = "Áries";
            return sign;
        } else if (date[0] >= 21 && date[1] == 4 || date[0] <= 20 && date[1] == 5) {
            sign = "Touro";
            return sign;
        } else if (date[0] >= 21 && date[1] == 5 || date[0] <= 20 && date[1] == 6) {
            sign = "Gêmeos";
            return sign;
        } else if (date[0] >= 21 && date[1] == 6 || date[0] <= 21 && date[1] == 7) {
            sign = "Câncer";
            return sign;
        } else if (date[0] >= 22 && date[1] == 7 || date[0] <= 22 && date[1] == 8) {
            sign = "Leão";
            return sign;
        } else if (date[0] >= 23 && date[1] == 8 || date[0] <= 22 && date[1] == 9) {
            sign = "Virgem";
            return sign;
        } else if (date[0] >= 23 && date[1] == 9 || date[0] <= 22 && date[1] == 10) {
            sign = "Libra";
            return sign;
        } else if (date[0] >= 23 && date[1] == 10 || date[0] <= 21 && date[1] == 11) {
            sign = "Escorpião";
            return sign;
        } else if (date[0] >= 22 && date[1] == 11 || date[0] <= 21 && date[1] == 12) {
            sign = "Sagitário";
            return sign;
        } else if (date[0] >= 22 && date[1] == 12 || date[0] <= 20 && date[1] == 1) {
            sign = "Capricórnio";
            return sign;
        } else if (date[0] >= 21 && date[1] == 1 || date[0] <= 19 && date[1] == 2) {
            sign = "Aquário";
            return sign;
        } else if (date[0] >= 20 && date[1] == 2 || date[0] <= 20 && date[1] == 3) {
            sign = "Peixes";
            return sign;
        }
        sign = "Ocorreu um erro, favor revise suas informações.";
        return sign;
    }

    /* Método com retorno em número fracionário, para calcular a idade atual do
    usuário.*/
    public static int showAge(int date[]) {
        LocalDate aniversario;
        aniversario = LocalDate.of(date[2],date[1], date[0]);
        final LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(aniversario, dataAtual);
        return periodo.getYears();
    }


    /* Método com retorno em número inteiro, para gerar o número da sorte do
    usuário.*/
    public static int takeLuckyNumber(int luckyNum) {
        luckyNum = (int) 1 + (int) (Math.random() * 98);
        return luckyNum;
    }

    // Método com retorno em String, para gerar a cor da sorte do usuário.
    public static String takeLuckyColor(String luckyColor) {
        int colorIndex;
        colorIndex = (int) 1 + (int) (Math.random() * 8);
        switch (colorIndex) {
            case 1:
                luckyColor = "Rosa";
                break;
            case 2:
                luckyColor = "Vermelho";
                break;
            case 3:
                luckyColor = "Azul";
                break;
            case 4:
                luckyColor = "Verde";
                break;
            case 5:
                luckyColor = "Cinza";
                break;
            case 6:
                luckyColor = "Laranja";
                break;
            case 7:
                luckyColor = "Violeta";
                break;
            case 8:
                luckyColor = "Amarelo";
                break;
            case 9:
                luckyColor = "Branco";
                break;
        }
        return luckyColor;
    }

    /* Método com retorno em String, que serve para indicar qual período do dia está
    e a forma de cumprimentar no texto resposta.*/
    public static String getDayTime(int time, String dayTime) {
        if (time < 12) {
            dayTime = "Bom dia!";
        } else if (time < 18) {
            dayTime = "Boa tarde!";
        } else {
            dayTime = "Boa Noite!";
        }
        return dayTime;
    }

    // Método sem retorno, usado para exibir a resposta ao final do sistema.
    public static void showResponse(String name, String dayTime, String sign, int gender, int date[],
             int age, int luckyNum, String luckyColor) {
        if (gender == 1 && age <= 23) {
            System.out.println("\n" + dayTime + " Srta. " + name + " nascida no dia " + date[0] + "/" + date[1] + "/"
                    + date[2] + ", é do signo de " + sign + " e possui atualmente " + age
                    + " anos. Seu número da sorte é " + luckyNum + " e sua cor da sorte é " + luckyColor + ".");
        } else if (gender == 1) {
            System.out.println("\n" + dayTime + " Sra. " + name + " nascida no dia " + date[0] + "/" + date[1] + "/" + date[2]
                    + ", é do signo de " + sign + " e possui atualmente " + age + " anos. Seu número da sorte é "
                    + luckyNum + " e sua cor da sorte é " + luckyColor + ".");
        } else {
            System.out.println("\n" + dayTime + " Sr. " + name + " nascido no dia " + date[0] + "/" + date[1] + "/" + date[2]
                    + ", é do signo de " + sign + " e possui atualmente " + age + " anos. Seu número da sorte é "
                    + luckyNum + " e sua cor da sorte é " + luckyColor + ".");
        }
    }

    /* Método com retorno em número inteiro, usado para questionar o usuário se ele
    deseja repetir o programa.*/
    public static int doQuestion() {
        int recursion;
        System.out.println("\nDeseja reiniciar o programa? \n1 pra 'sim'\n0 pra 'não'.");
        recursion = readInt();
        return recursion;
    }
}