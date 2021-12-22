BEGIN;
CREATE TABLE IF NOT EXISTS shipping_details (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  street_name text,
  city text,
  zip_code numeric,
  state text,
  country text
);

CREATE TABLE IF NOT EXISTS payment_details (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  paypal boolean,
  card_name text,
  card_number text,
  expiration_date date,
  verification_code text
);

ALTER TABLE user_account
  ADD payment_details_id UUID,
      shipping_details_id UUID,
      CONSTRAINT fk_payment_details
          FOREIGN KEY(payment_details_id)
        REFERENCES payment_details(id),
      CONSTRAINT fk_shipping_details
          FOREIGN KEY(shipping_details_id)
        REFERENCES shipping_details(id),
      CONSTRAINT email_unique UNIQUE (email);
COMMIT;
