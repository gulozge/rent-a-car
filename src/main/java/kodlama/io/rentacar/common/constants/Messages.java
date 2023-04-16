package kodlama.io.rentacar.common.constants;

public class Messages {
    public static class Car {
        public static final String NotExists = "CAR_NOT_EXISTS";
        public static final String Exists = "CAR_ALREADY_EXISTS";
        public static final String NotAvailable = "CAR_NOT_AVAİLABLE";
    }

    public static class Model {
        public static final String NotExists = "MODEL_NOT_EXISTS";
        public static final String Exists = "MODEL_ALREADY_EXISTS";
    }

    public static class Brand {
        public static final String NotExists = "BRAND_NOT_EXISTS";
        public static final String Exists = "BRAND_ALREADY_EXISTS";
    }

    public static class Maintenance {
        public static final String NotExists = "MAİNTENANCE_NOT_EXISTS";
        public static final String CarExists = "CAR_IS_CURRENTLY_UNDER_MAİNTENANCE";
        public static final String CarNotExists = "CAR_NOT_REGISTERED_FOR_MAİNTENANCE";
        public static final String CarIsRented = "CAR_IS_CURRENTLY_RENTED_AND_CANNOT_BE_SERVİCED_FOR_MAİNTENANCE";
    }

    public static class Rentel {
        public static final String NotExists = "RENTEL_NOT_EXISTS";
    }

    public static class Payment {
        public static final String NotFound = "PAYMENT_NOT_FOUND";
        public static final String CardNumberAlreadyExists = "CARD_NUMBER_ALREADY_EXISTS";
        public static final String NotEnoughMoney = "NOT_ENOUGH_MONEY";
        public static final String NotAvalidPayment = "NOT_A_VALİD_PAYMENT";
        public static final String Failed = "FAİLED";
    }

    public static class Invoice {
        public static final String NotFound = "INVOİCE_NOT_FOUND";
    }
}
