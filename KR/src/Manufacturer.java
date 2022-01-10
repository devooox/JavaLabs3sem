public enum Manufacturer {
    PHILIPS,
    OSRAM,
    XIAOMI,
    IKEA,
    MEGAMAN;

    @Override
    public String toString() {
        switch (this) {
            case PHILIPS : return "Philips";
            case OSRAM : return "Osram";
            case XIAOMI: return "Xiaomi";
            case IKEA: return "IKEA";
            case MEGAMAN: return "Megaman";
            default: return "No such manufacturer";
        }
    }

    public static Manufacturer toType(String s) throws EnumIncorrectException{
        Manufacturer delta;
        switch (s){
            case "Philips":
                delta = PHILIPS;
                break;
            case "Osram":
                delta = OSRAM;
                break;
            case "Xiaomi":
                delta = XIAOMI;
                break;
            case "IKEA":
                delta = IKEA;
                break;
            case "Megaman":
                delta = MEGAMAN;
                break;
            default:
                throw new EnumIncorrectException("Error data in enum");
        }
        return delta;
    }
}
