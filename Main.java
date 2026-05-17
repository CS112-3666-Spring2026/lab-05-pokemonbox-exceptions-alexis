import java.util.InputMismatchException;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		// DECLARATION + INITIALIZATION
		int choice = -1;
		boolean tryAgain = true;

		Scanner keyboard =
			new Scanner(System.in);

		Pokemon[] caught = {
			new Pokemon("Pikachu", "Electric"),
			new Pokemon("Bulbasaur", "Grass", "Poison"),
			new Pokemon("Charmeleon", "Fire"),
			new Pokemon("Squirtle", "Water"),
			new Pokemon("Butterfree", "Bug", "Flying"),
			new Pokemon("Pidgeotto", "Normal", "Flying")
		};

		// WELCOME
		System.out.println(
			"Preloading Pokemon Box..."
		);

		PokemonBox myBox = null;

		try {

			myBox =
				new PokemonBox(caught);

			System.out.println(
				"...Done!\n"
			);

		} catch (
			IllegalArgumentException iae
		) {

			System.out.println(
				iae.getMessage()
			);

			System.exit(0);
		}

		System.out.println(
			"---------------------------"
		);

		System.out.println(
			"| Welcome to Pokemon Box! |"
		);

		System.out.println(
			"---------------------------\n"
		);

		System.out.println(myBox);

		// INPUT + PROCESSING + OUTPUT
		do {

			try {

				System.out.println(
					"\nMAIN MENU"
				);

				System.out.println(
					"What would you like to do?"
				);

				System.out.println(
					"\t1) Add a New Pokemon "
				);

				System.out.println(
					"\t2) List All Pokemon "
				);

				System.out.println(
					"\t3) Exit Program \n"
				);

				System.out.print(
					"Enter choice number> "
				);

				choice =
					keyboard.nextInt();

				keyboard.nextLine();

				System.out.println();

				if (choice == 1) {

					System.out.println(
						"Enter Pokemon Info to be added:"
					);

					System.out.print(
						"Enter Pokemon Name> "
					);

					String name =
						keyboard.nextLine();

					System.out.print(
						"Enter Pokemon Type #1> "
					);

					String type1 =
						keyboard.nextLine();

					System.out.print(
						"Enter Pokemon Type #2 "
						+ "(none if no second type)> "
					);

					String type2 =
						keyboard.nextLine();

					type2 =
						(type2.equalsIgnoreCase("none"))
						? null
						: type2;

					try {

						Pokemon p =
							new Pokemon(
								name,
								type1,
								type2
							);

						try {

							myBox.add(p);

							System.out.println(
								"\n"
								+ name
								+ " added!"
							);

						} catch (
							PokemonAlreadyExistsException paee
						) {

							System.out.println(
								"\n"
								+ paee.getMessage()
							);

							System.out.println(
								"Please remember our "
								+ "region sustainability "
								+ "efforts in reducing "
								+ "habitat loss and "
								+ "environmental impacts."
							);
						}

					} catch (
						IllegalArgumentException iae
					) {

						System.out.println(
							"\nInvalid name, type #1, "
							+ "and/or type #2 entered."
						);

						System.out.println(
							"Please try again."
						);
					}

				} else if (choice == 2) {

					System.out.println(myBox);

				} else if (choice == 3) {

					keyboard.close();

					tryAgain = false;

				} else {

					System.out.println(
						"Invalid choice, please pick "
						+ "a valid option from the menu.\n"
					);
				}

			} catch (
				InputMismatchException ime
			) {

				System.out.println(
					"\nInvalid choice, please pick "
					+ "a valid option as an integer.\n"
				);

				keyboard.nextLine();
			}

		} while (tryAgain);

		System.out.println(
			"Thank you for using the Pokemon "
			+ "Box program :D see you later!"
		);
	}
}