//package poo.tp.premierspas;

class Hello {
  public static void main(String[] args) {
    if(args.length <1){
      System.err.println("Err: Entrée le nom SVP");
      System.exit(1);
    }
    String nom = args[0];
    System.out.println("Hello " + nom);  // Output user input
  }
}
