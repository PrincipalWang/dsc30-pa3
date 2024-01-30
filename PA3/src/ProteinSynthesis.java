/*
    Name: Chen Wang
    PID:  A17090044
 */

/**
 * ProteinSynthesis implementation
 *
 * @author Chen Wang
 * @since 1/30/2024
 */
class ProteinSynthesis {
    private static final int THREE = 3;

    /**
     * Creates an RNA by replacing each occurrence of ‘T’ with ‘U’,
     * saves the result in a queue and returns it.
     *
     * @param dna dna to be transcript
     * @return rna created
     * @throws IllegalArgumentException  if the length of the input is not divisible by 3
     */
    public CharQueue transcribeDNA(String dna) {
        if(dna.length() % THREE != 0){
            throw new IllegalArgumentException();
        }
        String rna = dna.replace('T','U');
        CharQueue res = new CharQueue(rna.length());
        for(int i = 0; i<rna.length(); i++){
            res.enqueue(rna.charAt(i));
        }
        return res;
    }

    /**
     * Translates a given RNA to a protein.
     *
     * @param rna rna to be translated
     * @return protein name
     */
    public CharQueue translateRNA(CharQueue rna) {
        CharQueue res = new CharQueue(rna.size()/THREE);
        while(!rna.isEmpty()){
            String codon = "";
            codon += rna.dequeue();
            codon += rna.dequeue();
            codon += rna.dequeue();
            char trans = CodonMap.getAminoAcid(codon);
            if(trans == 'M' || (!res.isEmpty() && res.peek() == 'M')){
                res.enqueue(trans);
            }
            if(trans == '*'){
                break;
            }
        }
        return res;
    }

}