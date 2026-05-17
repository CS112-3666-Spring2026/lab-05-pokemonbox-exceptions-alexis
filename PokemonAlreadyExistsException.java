public class PokemonAlreadyExistsException extends Exception {

	private Pokemon duplicate;

	public PokemonAlreadyExistsException() {
		super("ERROR! Pokemon already exists in box!");
	}

	public PokemonAlreadyExistsException(
			String message,
			Pokemon copy
	) {

		super(message + " Duplicate Pokemon = " + copy);

		this.duplicate = copy;
	}

	public Pokemon getDuplicate() {
		return this.duplicate;
	}
}