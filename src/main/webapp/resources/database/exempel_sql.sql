-- Hämtar alla beställningar med tillhörande rätter
SELECT
    b.id AS beställning_id,
    b.datum,
    b.tid,
    b.kommentar AS beställning_kommentar,
    r.id AS rätt_instans_id,
    a.titel AS alacarte_titel,
    a.beskrivning AS alacarte_beskrivning,
    a.pris,
    r.rätt_preferenser
FROM
    beställning b
        JOIN
    rätt_instans r ON b.id = r.beställning_id
        LEFT JOIN
    alacarte a ON r.alacarte_id = a.id
        LEFT JOIN
    typ t ON a.typ_id = t.id
ORDER BY
    b.datum, b.tid, b.id, r.id;