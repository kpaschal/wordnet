package kpaschal.wordnet.infrastructure.dictionary.file.utils;

/**
 * Contain static field with the copyright,licence text which exist at the
 * begining of index.pos and data.pos files
 *
 * @author
 */
public class PrincetonLicence {
    
    /**
     * Every index(.pos) and data(.pos) WordNet's database file starts with 
     * these lines. Every line starts with 2spaces and line's number
     */
    private static String clText_ = 
           "  1 This software and database is being provided to you, the LICENSEE, by \n"
  +"  2 Princeton University under the following license.  By obtaining, using  \n"
  +"  3 and/or copying this software and database, you agree that you have  \n"
  +"  4 read, understood, and will comply with these terms and conditions.:  \n"
  +"  5   \n"
  +"  6 Permission to use, copy, modify and distribute this software and  \n"
  +"  7 database and its documentation for any purpose and without fee or  \n"
  +"  8 royalty is hereby granted, provided that you agree to comply with  \n"
  +"  9 the following copyright notice and statements, including the disclaimer,  \n"
  +"  10 and that the same appear on ALL copies of the software, database and  \n"
  +"  11 documentation, including modifications that you make for internal  \n"
  +"  12 use or for distribution.  \n"
  +"  13   \n"
  +"  14 WordNet 2.1 Copyright 2005 by Princeton University.  All rights reserved.  \n"
  +"  15   \n"
  +"  16 THIS SOFTWARE AND DATABASE IS PROVIDED \"AS IS\" AND PRINCETON  \n"
  +"  17 UNIVERSITY MAKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR  \n"
  +"  18 IMPLIED.  BY WAY OF EXAMPLE, BUT NOT LIMITATION, PRINCETON  \n"
  +"  19 UNIVERSITY MAKES NO REPRESENTATIONS OR WARRANTIES OF MERCHANT-  \n"
  +"  20 ABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT THE USE  \n"
  +"  21 OF THE LICENSED SOFTWARE, DATABASE OR DOCUMENTATION WILL NOT  \n"
  +"  22 INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADEMARKS OR  \n"
  +"  23 OTHER RIGHTS.  \n"
  +"  24   \n"
  +"  25 The name of Princeton University or Princeton may not be used in  \n"
  +"  26 advertising or publicity pertaining to distribution of the software  \n"
  +"  27 and/or database.  Title to copyright in this software, database and  \n"
  +"  28 any associated documentation shall at all times remain with  \n"
  +"  29 Princeton University and LICENSEE agrees to preserve same.  ";
    
  public static String getCopyrightLicenceText(){
      return clText_;
  }
}
