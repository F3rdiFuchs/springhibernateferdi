package Enum;


public enum ECategory{
	animals,
	important,
	other,
	sports,
	technique,
	todo;
	
	public String toString()
	{
		switch(this)
		{
		case animals:
			return"animals";
		case important:
			return "important";
		case other:
			return "other";
		case sports:
			return "sports";
		case technique:
			return "technique";
		case todo:
			return "todo";
		default:
			return null;
		}
	}
}
