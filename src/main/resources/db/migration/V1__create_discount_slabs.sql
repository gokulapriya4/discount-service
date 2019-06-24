CREATE TABLE discount_slabs(
    id SERIAL PRIMARY KEY,
    user_type VARCHAR(10),
    start_amount INTEGER,
    end_amount INTEGER,
    discount_percentage INTEGER
);

INSERT INTO public.discount_slabs (user_type, start_amount, end_amount, discount_percentage) VALUES ('STANDARD', 1000, 3000, 10);
INSERT INTO public.discount_slabs (user_type, start_amount, end_amount, discount_percentage) VALUES ('STANDARD', 3000, 5000, 15);
INSERT INTO public.discount_slabs (user_type, start_amount, end_amount, discount_percentage) VALUES ('STANDARD', 5000, 999999, 20);
INSERT INTO public.discount_slabs (user_type, start_amount, end_amount, discount_percentage) VALUES ('PREMIUM', 500, 1000, 10);
INSERT INTO public.discount_slabs (user_type, start_amount, end_amount, discount_percentage) VALUES ('PREMIUM', 1000, 3000, 15);
INSERT INTO public.discount_slabs (user_type, start_amount, end_amount, discount_percentage) VALUES ('PREMIUM', 3000, 5000, 20);
INSERT INTO public.discount_slabs (user_type, start_amount, end_amount, discount_percentage) VALUES ('PREMIUM', 5000, 999999, 25);