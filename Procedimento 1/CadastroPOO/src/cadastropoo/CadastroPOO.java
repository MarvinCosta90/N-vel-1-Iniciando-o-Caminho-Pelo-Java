/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

/**
 *
 * @author Marvin
 */
import java.io.IOException;

public class CadastroPOO {

    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pessoa1 = new PessoaFisica(1, "Marvin", "11111111111", 25);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Ana", "22222222222", 52);
        
        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);
        System.out.println("Dados de Pessoa Fisica Armazenados.");
        
        try {
            repo1.persistir("pessoasFisicas.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar("pessoasFisicas.dat");
            System.out.println("Dados de Pessoa Fisica Recuperados.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (PessoaFisica pf : repo2.obterTodos()) {
            pf.exibir();
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridica pessoa3 = new PessoaJuridica(3, "XPTO Sales", "33333333333");
        PessoaJuridica pessoa4 = new PessoaJuridica(4, "XPTO Solutions", "44444444444");

        repo3.inserir(pessoa3);
        repo3.inserir(pessoa4);
        System.out.println("Dados de Pessoa Juridica Armazenados.");

        try {
            repo3.persistir("pessoasJuridicas.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar("pessoasJuridicas.dat");
            System.out.println("Dados de Pessoa Juridica Recuperados.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (PessoaJuridica pf : repo4.obterTodos()) {
            pf.exibir();
        }
    }
}