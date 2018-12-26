package tests;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.joda.time.LocalTime;

import controller.Fachada;
import exceptions.DisciplinaExistenteException;
import exceptions.IdDisciplinaExistenteException;

/**
	@Author: rique
*/

public class Test {

	public static void main(String[] args) throws DisciplinaExistenteException, IdDisciplinaExistenteException {
		
/*		Disciplina d = new Disciplina(1,"Inteligência Artificial","IA",60);
		
		if(Fachada.getInstance().contDisciplinas().cadastrarDisciplina(d)) {
			System.out.println("Cadastrada.");
		}else {
			System.out.println("Não cadastrada.");
		}
		
		Disciplina d2 = Fachada.getInstance().contDisciplinas().getDisciplinaById(1);
		
		System.out.println(d2.getNome());
		
		Disciplina d3 = new Disciplina(1,"Inteligência Artificial2","IA",60);
		
		if(Fachada.getInstance().contDisciplinas().cadastrarDisciplina(d3)) {
			System.out.println("Cadastrada.");
		}else {
			System.out.println("Não cadastrada.");
		}*/
		
		/*Professor prof = new Professor(1,"Henrique Nunes","123","123","IA");
		Fachada.getInstance().contProfessor().addProfessor(prof);
		
		if(Fachada.getInstance().contProfessor().getProfessor("123") != null) {
			System.out.println("Cadastrado com sucesso.");
		}else {
			System.out.println("Não foi cadastrado.");
		}
		
		List<Professor> profs = Fachada.getInstance().contProfessor().getProfessorList();
		
		List<Professor> profs2 = profs.stream().filter(p -> p != null).collect(Collectors.toList());
		
		profs.forEach(System.out::println);
		System.out.println();
		profs2.forEach(System.out::println);*/
		
		String input = "14:00";
		LocalTime localtime = LocalTime.parse(input);
		
		System.out.println(localtime.getHourOfDay()+":"+localtime.getMinuteOfHour());
		System.out.println(1%7);
		
		Random rn = new Random();
		
		
		BigInteger idTest = BigInteger.probablePrime(20, rn);
		int idOther = idTest.intValue(); 
		
		System.out.println(idTest);
		System.out.println(idOther);
		
	}
	
	
	public static List<Integer> primeNumbersTill(int n) {
	    return IntStream.rangeClosed(2, n)
	      .filter(x -> isPrime(x)).boxed()
	      .collect(Collectors.toList());
	}
	private static boolean isPrime(int number) {
	    return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
	      .filter(n -> (n & 0X1) != 0)
	      .allMatch(n -> number % n != 0);
	}
	

}

