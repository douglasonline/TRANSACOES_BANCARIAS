import * as React from 'react';
import axios from 'axios';
import {useEffect, useState} from 'react';
//import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Container from '@mui/material/Container';
import moment from 'moment';



export default function Transferencia() {

    const[getDatainicial,setDatainicial]= useState('')  
    const[getDatafinal,setDatafinal]=  useState('')
    const[getNomeoperador,setNomeoperador]=useState('')
    const[getSoma,setSoma]=useState('')

    /* const handleclick1=(e)=>{
        e.preventDefault()
        const transferencia={getDatainicial, getDatafinal,getNomeoperador}
        console.log(transferencia) 
         } */ 

const [transferencia1, setTransferencia1] = useState([]);
    useEffect(()=>
    {

      handleclick();  
      handleclick6();
      
    },[]) 


    async function handleclick()
    {

        const result = await axios.get("http://localhost:8080/transferencia");
            setTransferencia1(result.data);
            console.log(result.data);

    }

    async function handleclick2()
    {


        const result = await axios.get("http://localhost:8080/transferencia/Entredata?data_transferencia1="+ moment(getDatainicial).utc().format("YYYY-DD-MM") +"&data_transferencia2=" + moment(getDatafinal).utc().format("YYYY-DD-MM"));
            setTransferencia1(result.data);
            console.log(result.data);
            console.log(moment(getDatainicial).utc().format("YYYY-DD-MM")); 

    }

    async function handleclick3()
    {

        const result = await axios.get("http://localhost:8080/transferencia/nome_operador_transacao?nome_operador_transacao=" + getNomeoperador);
            setTransferencia1(result.data);
            console.log(result.data);

    }

    async function handleclick4()
    {

        const result = await axios.get("http://localhost:8080/transferencia/datatra?datatra="+ moment(getDatainicial).utc().format("YYYY-DD-MM"));
            setTransferencia1(result.data);
            console.log(result.data);

    }

    async function handleclick5()
    {

        const result = await axios.get("http://localhost:8080/transferencia/datatra?datatra="+ moment(getDatafinal).utc().format("YYYY-DD-MM"));
            setTransferencia1(result.data);
            console.log(result.data);

    }

    async function handleclick6()
    {

        const result1 = await axios.get("http://localhost:8080/transferencia/soma");
             setSoma(result1.data);
             console.log(result1.data); 

    }

    async function handleclick7()
    {

        const result = await axios.get("http://localhost:8080/transferencia/dataEoperador?data_transferencia="+ moment(getDatainicial).utc().format("YYYY-DD-MM") + "&nome_operador_transacao=" + getNomeoperador);
              setTransferencia1(result.data);
              console.log(result.data); 

    }

    async function handleclick8()
    {

        const result = await axios.get("http://localhost:8080/transferencia/dataEoperador?data_transferencia="+ moment(getDatafinal).utc().format("YYYY-DD-MM") + "&nome_operador_transacao=" + getNomeoperador);
              setTransferencia1(result.data);
              console.log(result.data); 

    }

    async function funcoes(){

    if(getDatainicial && getDatafinal && getNomeoperador === ""){
        handleclick2()   
    }
    else if(getDatainicial === "" && getDatafinal === "" && getNomeoperador){ 

        handleclick3()

    }
    else if(getDatainicial && getDatafinal === "" && getNomeoperador === ""){ 

      handleclick4()

    }

    else if(getDatainicial === "" && getDatafinal && getNomeoperador === ""){ 

      handleclick5()

    }

    else if(getDatainicial && getDatafinal && getNomeoperador){ 

      handleclick3()
      
    }
 
    else if(getDatainicial === "" && getDatafinal === "" && getNomeoperador === ""){ 

      handleclick()
      
    }

    else if(getDatainicial !== "" && getDatafinal === "" && getNomeoperador !== ""){ 

      handleclick7()
      
    }

    else if(getDatainicial === "" && getDatafinal !== "" && getNomeoperador !== ""){ 

      handleclick8()
      
    }

    }


  return (

    <Container maxWidth="sm"
      component="form"
      sx={{
        '& > :not(style)': { 
            
            m: 1,
            width: '40ch'
        
        },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Data de Início: 00-00-0000" variant="outlined"                value={getDatainicial}   onChange={(e) => setDatainicial(e.target.value)}/>
      <TextField id="outlined-basic" label="Data de Fim:  00-00-0000" variant="outlined"                   value={getDatafinal}     onChange={(e) => setDatafinal(e.target.value)} />
      <TextField id="outlined-basic" label="Nome Operador transação" variant="outlined"       value={getNomeoperador}  onChange={(e)=>setNomeoperador(e.target.value)} />   
      
      
      <Button variant="contained" color='secondary' onClick={funcoes}>Pesquisar</Button> 


  
      <div className='App2'> 
          
             


                <table class='table table-striped' align="center">

                 <thead>  

                     <tr>
                         <th scope='col'>#</th>
                         <th scope='col'>Data da transferencia</th>
                         <th scope='col'>Valor</th>
                         <th scope='col'>Tipo</th>
                         <th scope='col'>Nome do Operador de transação</th>
                         <th scope='col'>Id da conta</th>

                     </tr>
                 </thead>


                     {transferencia1.map(function fn(item)
                     {

                         return(

                        <tbody>
                           <tr>
                           
                           <th scope="row">{item.id}</th>
                           <td>{moment(item.datatransferencia).utc().format("DD-MM-YYYY")}</td>
                           <td>{item.valor}</td>
                           <td>{item.tipo}</td>
                           <td>{item.nomeoperadortransacao}</td>
                           <td>{item.conta_id}</td>
                           
                           </tr>
                        
                        </tbody>

                         );
                         })}

                        <tr>
          		          <td colspan="6"> Saldo total: R$ {getSoma}  </td> 
          	            </tr>  

                </table>
          </div>




    </Container> 




  );


}


